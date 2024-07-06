// src/components/Menu.tsx
import React, { useState, useEffect } from 'react';

interface MenuItem {
  id: number;
  name: string;
  url: string;
}

interface MenuProps {
  onMenuItemClick: (item: MenuItem) => void;
}

const Menu: React.FC<MenuProps> = ({ onMenuItemClick }) => {
  const [menuItems, setMenuItems] = useState<MenuItem[]>([]);

  useEffect(() => {
    fetch('/menuData.json') // replace with your menu endpoint
      .then(response => response.json())
      .then(data => setMenuItems(data))
      .catch(error => console.error('Error fetching menu:', error));
  }, []);

  return (
    <div className="bg-light border-right" id="sidebar-wrapper">
      <div className="sidebar-heading">Menu</div>
      <div className="list-group list-group-flush">
        {menuItems.map(item => (
          <button
            key={item.id}
            className="list-group-item list-group-item-action bg-light"
            onClick={() => onMenuItemClick(item)}
          >
            {item.name}
          </button>
        ))}
      </div>
    </div>
  );
};

export default Menu;
