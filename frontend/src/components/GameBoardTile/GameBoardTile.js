import React from 'react';
import PropTypes from 'prop-types';
import './GameBoardTile.css'
import * as GeometryService from '../../services/GeometryService.js'

function GameBoardTile(props) {
    return (
        <path
            className="game-board-tile"
            d={GeometryService.describeArc(props.cx, props.cy, props.r, props.startDegree, props.endDegree)}
            strokeWidth={props.strokeWidth}
            onClick={() => { console.log(`Clicked ${props.i}`) }}
        />
    );
}

GameBoardTile.propTypes = {
    i: PropTypes.number.isRequired,
    r: PropTypes.number.isRequired,
    cx: PropTypes.number.isRequired,
    cy: PropTypes.number.isRequired,
    startDegree: PropTypes.number.isRequired,
    endDegree: PropTypes.number.isRequired,
    strokeWidth: PropTypes.number.isRequired,
}

export default GameBoardTile
