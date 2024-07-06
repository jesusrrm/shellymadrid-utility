// src/App.tsx
import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Banner from './components/Banner';
import Menu from './components/Menu';
import Content from './components/Content';

const App: React.FC = () => {
  const [contentUrl, setContentUrl] = useState<string | null>(null);

  const handleMenuItemClick = (item: { url: string }) => {
    setContentUrl(item.url);
  };

  return (
    <div>
      <Banner />
      <div className="d-flex" id="wrapper">
        <Menu onMenuItemClick={handleMenuItemClick} />
        <div id="page-content-wrapper">
          <div className="container-fluid">
            <Content url={contentUrl} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;
