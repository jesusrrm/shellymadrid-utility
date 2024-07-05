import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Greeting from './components/Greeting';

const App: React.FC = () => {
  return (
    <div className="App">
      <Greeting />
    </div>
  );
}

export default App;
