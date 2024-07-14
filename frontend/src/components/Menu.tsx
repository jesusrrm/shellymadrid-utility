import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/globalStyles.css'; // Import the global styles

type MenuItem = {
    name: string;
    path: string;
};

const menuItems: MenuItem[] = [
    { name: 'Inicio', path: '/' },
    { name: 'Quién es ShellyMadrid', path: '/who-we-are' },
    { name: 'Información de contacto', path: '/contact-info' },
    { name: 'Control de batería de laptop', path: '/battery-status' },
    { name: 'Dispositivos Shelly por configurar', path: '/devices-to-configure' },
    { name: 'Cambio de cuenta cloud de equipos Shelly', path: '/change-cloud-account' }
];

const Menu: React.FC = () => {
    const [isOpen, setIsOpen] = useState(false);

    const toggleMenu = () => {
        setIsOpen(!isOpen);
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container left" >
                <button className="navbar-toggler" type="button" onClick={toggleMenu}>
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className={`collapse navbar-collapse ${isOpen ? 'show' : ''}`}>
                    <ul className="navbar-nav flex-column">
                        {menuItems.map((item, index) => (
                            <li className="nav-item" key={index}>
                                <Link to={item.path} className="nav-link" onClick={toggleMenu}>{item.name}</Link>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
        </nav>
    );
};

export default Menu;
