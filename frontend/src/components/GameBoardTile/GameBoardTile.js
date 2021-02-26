import React from 'react';
import PropTypes from 'prop-types';
import './GameBoardTile.css'
import * as GeometryService from '../../services/GeometryService.js'

function GameBoardTile(props) {
    return (
        <path
            className={props.isActive ? "game-board-tile-active" : "game-board-tile-inactive"}
            d={GeometryService.describeArc(props.cx, props.cy, props.r, props.startDegree, props.endDegree)}
            strokeWidth={props.strokeWidth}
            stroke={props.isActive ? props.activeColor : props.inactiveColor}
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
    activeColor: PropTypes.string.isRequired,
    inactiveColor: PropTypes.string.isRequired,
    isActive: PropTypes.bool.isRequired,
}

export default GameBoardTile
