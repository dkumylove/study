import { Component } from 'react';

class Color extends Component {
  state = { // 상태값
    color: 'blue',
  };

  changeColor(color) {
    console.log(this);
  }

  render() {  // 컴포넌트의 필수
    const { color } = this.state;
    return (
      <>
        <div
          style={{ background: color, width: '100px', height: '100px' }}
        ></div>
        <button type="button" onClick={this.changeColor}>RED</button>
        <button type="button">ORANGE</button>
        <button type="button">GREEN</button>
      </>
    );
  }
}

export default Color;