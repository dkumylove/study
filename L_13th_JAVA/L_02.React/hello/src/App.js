// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;

const App = () => {
  const name = 'js';

  const style = {
    backgroundColor: 'orange',
    color: 'white',
    height: '100px',
  };

  return (
    <>
      {/* 주석 .... */}

      <div className="subject" style={style}>
        첫번째 컴포넌트!!
      </div>
      <div style={{ color: 'blue' }}>신나는, {name && name} 공부</div>
      {name === 'React' && <h1>아! 재미있다!</h1>}
      <input
        // 주석...
        type="text"
      />
    </>
  );
};

export default App;
