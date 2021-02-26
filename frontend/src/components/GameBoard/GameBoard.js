import React from 'react';
import PropTypes from 'prop-types';
import GameBoardDivider from '../GameBoardDivider/GameBoardDivider';
import GameBoardTile from '../GameBoardTile/GameBoardTile';
import './GameBoard.css';

function GameBoard(props) {
  const [windowDimensions, setWindowDimensions] = React.useState({
    height: window.innerHeight,
    width: window.innerWidth
  });

  const outerDiameter = Math.min(windowDimensions.height, windowDimensions.width) * 0.75;
  const outerRadius = outerDiameter / 2;
  const innerRadius = outerRadius * 0.8;
  const borderStrokeWidth = outerDiameter * 0.01;
  const cx = (outerDiameter / 2) + (borderStrokeWidth / 2);
  const cy = cx;
  const svgHeight = outerDiameter + borderStrokeWidth;
  const svgWidth = svgHeight;

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
    const { size } = props;
    const fillRadius = (outerRadius - innerRadius) / 2 + innerRadius;
    const fillStrokeWidth = (outerRadius - innerRadius - borderStrokeWidth) * 1.015; // To compensate for the imprecision and blend the divider and border

    const fillCircumference = 2 * Math.PI * fillRadius;
    const dividerCircumference = borderStrokeWidth; // Make the divider the same thickness as the border
    const tileCircumference = (fillCircumference - (dividerCircumference * size)) / size;

    const dividerDegrees = dividerCircumference / fillCircumference * 360;
    const tileDegrees = tileCircumference / fillCircumference * 360;

    const gameBoard = [];

    var degreePos = 0;

    for (var i = 0; i < size; i++) {
      gameBoard.push(
        <GameBoardTile
          key={i}
          i={i}
          r={fillRadius}
          cx={cx}
          cy={cy}
          startDegree={degreePos}
          endDegree={degreePos + tileDegrees}
          strokeWidth={fillStrokeWidth}
          activeColor={props.activeTileColor}
          inactiveColor={props.inactiveTileColor}
          isActive={true} // TODO: Set this based on the state of the global game board array
        />
      );

      degreePos += tileDegrees;

      const divKey = `div${i}`;

      gameBoard.push(
        <GameBoardDivider
          key={divKey}
          r={fillRadius}
          cx={cx}
          cy={cy}
          startDegree={degreePos}
          endDegree={degreePos + dividerDegrees}
          strokeWidth={fillStrokeWidth}
          color={props.borderColor}
        />
      );

      degreePos += dividerDegrees;
    }

    return gameBoard;
  }

  return (
    <div>
      <svg
        height={svgHeight}
        width={svgWidth}
      >
        <circle
          className="game-board-outline"
          stroke={props.borderColor}
          strokeWidth={borderStrokeWidth}
          r={outerRadius}
          cx={cx}
          cy={cy}
        />
        <circle
          className="game-board-outline"
          stroke={props.borderColor}
          strokeWidth={borderStrokeWidth}
          r={innerRadius}
          cx={cx}
          cy={cy}
        />
        {buildGameBoard()}
      </svg>
    </div>
  );
}

GameBoard.propTypes = {
  size: PropTypes.number.isRequired,
  borderColor: PropTypes.string.isRequired,
  activeTileColor: PropTypes.string.isRequired,
  inactiveTileColor: PropTypes.string.isRequired,
}

export default GameBoard
