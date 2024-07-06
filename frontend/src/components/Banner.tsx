// src/components/Banner.tsx
import React from 'react';

const Banner: React.FC = () => {
  return (
    <div className="bg-primary text-white text-center py-3">
        <img src="/images/www.shellymadrid.com.gif" alt="Banner" className="img-fluid" />

      <h1>My Application</h1>
    </div>
  );
};

export default Banner;
