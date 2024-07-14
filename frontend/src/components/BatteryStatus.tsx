import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

interface BatteryStatusProps {
    apiUrl: string;
}

const BatteryStatus: React.FC<BatteryStatusProps> = ({ apiUrl }) => {
    const [batteryLevel, setBatteryLevel] = useState<number | null>(null);
    const [relayOffThreshold, setRelayOffThreshold] = useState<number>(80);
    const [relayOnThreshold, setRelayOnThreshold] = useState<number>(20);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchBatteryStatus = async () => {
            try {
                const response = await fetch(apiUrl);
                const data = await response.json();
                setBatteryLevel(data.batteryLevel);
            } catch (err) {
                setError('Error fetching battery status');
            }
        };

        fetchBatteryStatus();
        const intervalId = setInterval(fetchBatteryStatus, 60000); // Fetch every minute

        return () => clearInterval(intervalId);
    }, [apiUrl]);

    const handleRelayOffThresholdChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setRelayOffThreshold(Number(e.target.value));
    };

    const handleRelayOnThresholdChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setRelayOnThreshold(Number(e.target.value));
    };

    const handleSaveSettings = () => {
        console.log('Relay Off Threshold:', relayOffThreshold);
        console.log('Relay On Threshold:', relayOnThreshold);
        // Aquí puedes agregar la lógica para enviar estos valores al backend o procesarlos según necesites
    };

    return (
        <div className="container mt-4 p-4 border rounded shadow-sm bg-white">
            <h2 className="mb-4">Battery Status</h2>
            {error ? (
                <div className="alert alert-danger">{error}</div>
            ) : batteryLevel !== null ? (
                <div className="alert alert-info">Current Battery Level: {batteryLevel}%</div>
            ) : (
                <div className="alert alert-secondary">Loading...</div>
            )}
            <div className="settings">
                <div className="form-group">
                    <label htmlFor="relayOffThreshold">Relay Off Threshold (%):</label>
                    <input
                        id="relayOffThreshold"
                        className="form-control"
                        type="number"
                        value={relayOffThreshold}
                        onChange={handleRelayOffThresholdChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="relayOnThreshold">Relay On Threshold (%):</label>
                    <input
                        id="relayOnThreshold"
                        className="form-control"
                        type="number"
                        value={relayOnThreshold}
                        onChange={handleRelayOnThresholdChange}
                    />
                </div>
                <button className="btn btn-primary" onClick={handleSaveSettings}>Save Settings</button>
            </div>
        </div>
    );
};

export default BatteryStatus;
