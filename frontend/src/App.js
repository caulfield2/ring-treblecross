import './App.css';
import GameBoard from './components/GameBoard/GameBoard';

function App() {
  return (
    <div className="app">
      <GameBoard
        size={30}
      />
    </div>
  );
}

export default App;
