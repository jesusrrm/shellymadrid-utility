import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/Menu.css';

type MenuItem = {
    name: string;
    path: string;
};

const menuItems: MenuItem[] = [
    { name: 'Inicio', path: '/' },
    { name: 'Quién es ShellyMadrid', path: '/who-we-are' },
    { name: 'Información de contacto', path: '/contact-info' },
    { name: 'Control de batería de laptop', path: '/battery-status' },
    { name: 'Dispositivos Shelly por configurar', path: '/battery-status' },
    { name: 'Cambio de cuenta cloud de equipos Shelly', path: '/battery-status' } 



];

const Menu: React.FC = () => {
    const [isOpen, setIsOpen] = useState(false);

    const toggleMenu = () => {
        setIsOpen(!isOpen);
    };

    return (
        <div className="menu-container">
            <div className="menu-toggle" onClick={toggleMenu}>
                &#9776;
            </div>
            <nav className={`menu ${isOpen ? 'open' : ''}`}>
                <ul>
                    {menuItems.map((item, index) => (
                        <li key={index}>
                            <Link to={item.path} onClick={toggleMenu}>{item.name}</Link>
                        </li>
                    ))}
                </ul>
            </nav>
        </div>
    );
};

export default Menu;
