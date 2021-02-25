import React from 'react';
import PropTypes from 'prop-types';
import './GameBoardDivider.css'
import * as GeometryService from '../../services/GeometryService.js'

function GameBoardDivider(props) {
    return (
        <path
            className="game-board-divider"
            d={GeometryService.describeArc(props.cx, props.cy, props.r, props.startDegree, props.endDegree)}
            strokeWidth={props.strokeWidth}
        />
    );
}

GameBoardDivider.propTypes = {
    r: PropTypes.number.isRequired,
    cx: PropTypes.number.isRequired,
    cy: PropTypes.number.isRequired,
    startDegree: PropTypes.number.isRequired,
    endDegree: PropTypes.number.isRequired,
    strokeWidth: PropTypes.number.isRequired,
}

export default GameBoardDivider
