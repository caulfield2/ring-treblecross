import React from 'react';
import PropTypes from 'prop-types';

function GameBoardTile(props) {
    return (<div />);
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
