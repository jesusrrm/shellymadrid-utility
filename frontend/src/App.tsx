import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/globalStyles.css';


import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import WhoWeAre from './components/WhoWeAre';
import ContactInfo from './components/ContactInfo';
import Menu from './components/Menu';
import TopBanner from './components/TopBanner';
import BatteryStatus from './components/BatteryStatus';
import Devices from './components/Devices';


const App: React.FC = () => {
    return (
        <Router>
            <div className="App">
                <TopBanner />
                <div className="main-content">
                    <Menu />
                    <div className="content">
                        <Routes>
                            <Route path="/" element={<Devices />} />

                            <Route path="/who-we-are" element={<WhoWeAre />} />
                            <Route path="/contact-info" element={<ContactInfo />} />
                            <Route path="/battery-status"  element={<BatteryStatus apiUrl={''} />} />

                        </Routes>
                    </div>
                </div>
            </div>
        </Router>
    );
};

export default App;
