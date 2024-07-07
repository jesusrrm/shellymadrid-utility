import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import WhoWeAre from './components/WhoWeAre';
import ContactInfo from './components/ContactInfo';
import Menu from './components/Menu';
import TopBanner from './components/TopBanner';
import './App.css';

const App: React.FC = () => {
    return (
        <Router>
            <div className="App">
                <TopBanner />
                <div className="main-content">
                    <Menu />
                    <div className="content">
                        <Routes>
                            <Route path="/" element={<Home />} />
                            <Route path="/who-we-are" element={<WhoWeAre />} />
                            <Route path="/contact-info" element={<ContactInfo />} />
                        </Routes>
                    </div>
                </div>
            </div>
        </Router>
    );
};

export default App;
