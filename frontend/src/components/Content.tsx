// src/components/Content.tsx
import React, { useState, useEffect } from 'react';

interface ContentProps {
  url: string | null;
}

interface ContentData {
  title: string;
  body: string;
}

const Content: React.FC<ContentProps> = ({ url }) => {
  const [content, setContent] = useState<ContentData | null>(null);

  useEffect(() => {
    if (url) {
      fetch(url)
        .then(response => response.json())
        .then(data => setContent(data))
        .catch(error => console.error('Error fetching content:', error));
    }
  }, [url]);

  return (
    <div className="p-4">
      {content ? (
        <div>
          <h2>{content.title}</h2>
          <p>{content.body}</p>
        </div>
      ) : (
        <p>Select an item from the menu to see its content.</p>
      )}
    </div>
  );
};

export default Content;
