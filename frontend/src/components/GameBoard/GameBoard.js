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

  function buildGameBoardTest() {
    const fillStrokeWidth = outerRadius - innerRadius - borderStrokeWidth;
    const fillRadius = (outerRadius - innerRadius) / 2 + innerRadius;
    const fillCircumference = 2 * Math.PI * fillRadius;

    const transform = `rotate(270, ${cx}, ${cy})`;

    return (
      <circle
        strokeWidth={fillStrokeWidth}
        strokeDasharray={fillCircumference}
        strokeDashoffset={fillCircumference / 2}
        r={fillRadius}
        cx={cx}
        cy={cy}
        transform={transform}
        stroke="white"
        fill="transparent"
      />
    );
  }

  function buildGameBoard() {

  }

  const outerDiameter = Math.min(windowDimensions.height, windowDimensions.width) * 0.75;
  const outerRadius = outerDiameter / 2;
  const innerRadius = outerRadius * 0.8;
  const borderStrokeWidth = outerDiameter * 0.01;
  const cx = (outerDiameter / 2) + (borderStrokeWidth / 2);
  const cy = cx;
  const svgHeight = outerDiameter + borderStrokeWidth;
  const svgWidth = svgHeight;

  return (
    <div>
      <svg
        height={svgHeight}
        width={svgWidth}
      >
        <circle
          className="game-board-outline"
          strokeWidth={borderStrokeWidth}
          r={outerRadius}
          cx={cx}
          cy={cy}
        />
        <circle
          className="game-board-outline"
          strokeWidth={borderStrokeWidth}
          r={innerRadius}
          cx={cx}
          cy={cy}
        />
        {buildGameBoardTest()}
      </svg>
    </div>
  );
}

export default GameBoard
