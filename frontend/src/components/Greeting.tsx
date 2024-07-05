import React, { useEffect, useState } from 'react';

// Define a type for the JSON response expected from the server
type GreetingResponse = {
  message: string;
};

const Greeting: React.FC = () => {
  const [message, setMessage] = useState<string>('');

  useEffect(() => {
    fetch('greeting')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json() as Promise<GreetingResponse>; // Assert response.json() to GreetingResponse type
      })
      .then(data => setMessage(data.message))
      .catch(error => console.error('Error fetching greeting:', error));
  }, []);

  return (
    <div className="container mt-5">
      <h1>{message}</h1>
    </div>
  );
};

export default Greeting;
