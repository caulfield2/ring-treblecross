import React from 'react';
import PropTypes from 'prop-types';

function GameBoardDivider(props) {
    return (<div />);
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
