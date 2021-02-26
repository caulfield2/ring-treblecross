import './App.css';
import GameBoard from './components/GameBoard/GameBoard';

function App() {
  return (
    <div className="app">
      <GameBoard
        size={30}
        borderColor="black"
        activeTileColor="white"
        inactiveTileColor="gray"
      />
    </div>
  );
}

export default App;
