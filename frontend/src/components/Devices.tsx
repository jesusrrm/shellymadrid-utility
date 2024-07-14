import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import DeviceDetailsModal from './DeviceDetailsModal';

interface ShellyDevice {
    id: string;
    name: string;
    ipAddress: string;
    hostname: string;
    device: string;
    version: string;
}

const ShellyDevices: React.FC = () => {
    const [devices, setDevices] = useState<ShellyDevice[]>([]);
    const [selectedDevice, setSelectedDevice] = useState<ShellyDevice | null>(null);
    const [error, setError] = useState<string | null>(null);
    const [detailsVisible, setDetailsVisible] = useState<boolean>(false);
    const [loading, setLoading] = useState<boolean>(false);
    const [baseIp, setBaseIp] = useState<string>('');
    const [baseIpOptions, setBaseIpOptions] = useState<string[]>(['192.168.0', '192.168.1']);

    const fetchDevices = async () => {
        setLoading(true);
        try {
            const response = await fetch('/api/devices/discovered');
            const data = await response.json();
            setDevices(data);
        } catch (err) {
            setError('Error fetching devices');
        } finally {
            setLoading(false);
        }
    };

    const fetchBaseIpOptions = async () => {
        try {
            const response = await fetch('/api/base-ip-options');
            const data = await response.json();
            setBaseIpOptions(data);
            if (data.length > 0) {
                setBaseIp(data[0]); // Set the first base IP as default
            }
        } catch (err) {
            setBaseIp('192.168.0');
        }
    };

    const refreshDevices = async () => {
        if (!baseIp) {
            setError('Please select a base IP.');
            return;
        }
        setLoading(true);
        try {
            const response = await fetch(`/api/devices/discover?baseIp=${baseIp}`);
            const data = await response.json();
            setDevices(data);
        } catch (err) {
            setError('Error refreshing devices');
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchDevices();
        fetchBaseIpOptions();
    }, []);

    const handleViewDetails = (device: ShellyDevice) => {
        setSelectedDevice(device);
        setDetailsVisible(true);
    };

    const handleSaveChanges = async (updatedDevice: ShellyDevice) => {
        try {
            const response = await fetch(`/api/shelly/devices/${updatedDevice.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(updatedDevice),
            });

            if (response.ok) {
                alert('Device updated successfully');
                setDevices(devices.map(device => device.id === updatedDevice.id ? updatedDevice : device));
            } else {
                setError('Error updating device');
            }
        } catch (err) {
            setError('Error updating device');
        }
        setDetailsVisible(false);
    };

    return (
        <div className="container mt-4">
            <h2 className="text-primary">Shelly Devices</h2>
            <div className="card p-3">
                <div className="d-flex align-items-center">
                    <div className="me-3">
                        <label htmlFor="baseIp" className="form-label">Select Base IP</label>
                        <select
                            id="baseIp"
                            className="form-select"
                            value={baseIp}
                            onChange={(e) => setBaseIp(e.target.value)}
                        >
                            {baseIpOptions.map((option) => (
                                <option key={option} value={option}>
                                    {option}
                                </option>
                            ))}
                        </select>
                    </div>
                    <button className="btn btn-primary" onClick={refreshDevices} disabled={loading}>
                        {loading ? (
                            <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                        ) : (
                            'Buscar equipos en la red'
                        )}
                    </button>
                </div>
            </div>

            {error && <div className="alert alert-danger mt-3">{error}</div>}
            {loading ? (
                <div className="d-flex justify-content-center mt-3">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
            ) : (
                <div className="table-responsive mt-3">
                    <table className="table table-hover">
                        <thead className="thead-dark">
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">IP Address</th>
                                <th scope="col">Hostname</th>
                                <th scope="col">Device</th>
                                <th scope="col">Version</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {devices.map((device) => (
                                <tr key={device.id}>
                                    <td>{device.name}</td>
                                    <td>{device.ipAddress}</td>
                                    <td>{device.hostname}</td>
                                    <td>{device.device}</td>
                                    <td>{device.version}</td>
                                    <td>
                                        <button className="btn btn-info btn-sm" onClick={() => handleViewDetails(device)}>
                                            View Details
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}

            <DeviceDetailsModal
                device={selectedDevice}
                visible={detailsVisible}
                onClose={() => setDetailsVisible(false)}
                onSave={handleSaveChanges}
            />
        </div>
    );
};

export default ShellyDevices;
