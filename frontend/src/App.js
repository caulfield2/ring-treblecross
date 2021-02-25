import './App.css';
import GameBoard from './components/GameBoard/GameBoard';

function App() {
  return (
    <div className="App">
      <GameBoard
        size={3}
      />
    </div>
  );
}

export default App;
