import React from 'react';
import { Modal, Button, Form } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

interface ShellyDevice {
    id: string;
    name: string;
    ipAddress: string;
    hostname: string;
    device: string;
    version: string;
}

interface DeviceDetailsModalProps {
    device: ShellyDevice | null;
    visible: boolean;
    onClose: () => void;
    onSave: (updatedDevice: ShellyDevice) => void;
}

const DeviceDetailsModal: React.FC<DeviceDetailsModalProps> = ({ device, visible, onClose, onSave }) => {
    const [updatedDevice, setUpdatedDevice] = React.useState<ShellyDevice | null>(device);

    React.useEffect(() => {
        setUpdatedDevice(device);
    }, [device]);

    if (!updatedDevice) {
        return null;
    }

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { id, value } = e.target;
        setUpdatedDevice({ ...updatedDevice, [id]: value });
    };

    const handleSave = () => {
        if (updatedDevice) {
            onSave(updatedDevice);
        }
    };

    return (
        <Modal show={visible} onHide={onClose}>
            <Modal.Header closeButton>
                <Modal.Title>Device Details: {updatedDevice.name}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="name">Device Name</Form.Label>
                        <Form.Control
                            type="text"
                            id="name"
                            value={updatedDevice.name}
                            onChange={handleChange}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="ipAddress">Device IP Address</Form.Label>
                        <Form.Control
                            type="text"
                            id="ipAddress"
                            value={updatedDevice.ipAddress}
                            onChange={handleChange}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="hostname">Hostname</Form.Label>
                        <Form.Control
                            type="text"
                            id="hostname"
                            value={updatedDevice.hostname}
                            onChange={handleChange}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="device">Device</Form.Label>
                        <Form.Control
                            type="text"
                            id="device"
                            value={updatedDevice.device}
                            onChange={handleChange}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="version">Version</Form.Label>
                        <Form.Control
                            type="text"
                            id="version"
                            value={updatedDevice.version}
                            onChange={handleChange}
                        />
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onClose}>
                    Close
                </Button>
                <Button variant="primary" onClick={handleSave}>
                    Save Changes
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default DeviceDetailsModal;
