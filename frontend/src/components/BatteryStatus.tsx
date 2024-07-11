import React, { useEffect, useState } from 'react';
import '../css/BatteryStatus.css';


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
        <div className="battery-status">
            <h2>Battery Status</h2>
            {error ? (
                <p className="error">{error}</p>
            ) : batteryLevel !== null ? (
                <p>Current Battery Level: {batteryLevel}%</p>
            ) : (
                <p>Loading...</p>
            )}
            <div className="settings">
                <div className="setting">
                    <label>Relay Off Threshold (%):</label>
                    <input
                        type="number"
                        value={relayOffThreshold}
                        onChange={handleRelayOffThresholdChange}
                    />
                </div>
                <div className="setting">
                    <label>Relay On Threshold (%):</label>
                    <input
                        type="number"
                        value={relayOnThreshold}
                        onChange={handleRelayOnThresholdChange}
                    />
                </div>
                <button onClick={handleSaveSettings}>Save Settings</button>
            </div>
        </div>
    );
};

export default BatteryStatus;
