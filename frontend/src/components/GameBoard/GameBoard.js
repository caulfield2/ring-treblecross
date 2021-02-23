import React from 'react';
import './GameBoard.css'

function GameBoard() {
  const [windowDimensions, setWindowDimensions] = React.useState({
    height: window.innerHeight,
    width: window.innerWidth
  });

  React.useEffect(() => {
    function handleResize() {
      setWindowDimensions({
        height: window.innerHeight,
        width: window.innerWidth
      })
    }

    window.addEventListener('resize', handleResize);

    return () => {
      window.removeEventListener('resize', handleResize);
    }
  });

  function buildGameBoard() {

  }

  const diameter = Math.min(windowDimensions.height, windowDimensions.width) * 0.75;
  const radius = diameter / 2;
  const strokeWidth = 4;
  const cx = (diameter / 2) + (strokeWidth / 2);
  const cy = cx;
  const svgHeight = diameter + strokeWidth;
  const svgWidth = svgHeight;

  return (
    <div>
      <svg
        height={svgHeight}
        width={svgWidth}
      >
        <circle
          strokeWidth={strokeWidth}
          r={radius}
          cx={cx}
          cy={cy}
        />
        <circle
          strokeWidth={strokeWidth}
          r={radius * 0.8}
          cx={cx}
          cy={cy}
        />
        {buildGameBoard()}
      </svg>
    </div>
  );
}

export default GameBoard
