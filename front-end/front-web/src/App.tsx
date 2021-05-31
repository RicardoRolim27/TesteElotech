import React from 'react';
import Routes from './Routes';
import './App.css';

function App() {
  return (
    <>
      <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
      </head>
      <div className="container">
        <Routes/>
      </div>
    </>
  );
}

export default App;
