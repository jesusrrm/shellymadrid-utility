import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/Menu.css';

type MenuItem = {
    name: string;
    path: string;
};

const menuItems: MenuItem[] = [
    { name: 'Home', path: '/' },
    { name: 'Who We Are', path: '/who-we-are' },
    { name: 'Contact Info', path: '/contact-info' }
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
