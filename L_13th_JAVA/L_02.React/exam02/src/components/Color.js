import { Component } from 'react';

class Color extends Component {
  state = { // 상태값
    color: 'blue',
  };

  render() {  // 컴포넌트의 필수

    // function changeColor(color) {
    //     console.log(this);
    // }
    
    // const changeColor = (color) => console.log(this);  // Color
    const changeColor = (color) => this.setState({ color }); // Color

    const { color } = this.state;
    return (
      <>
        <div
          style={{ background: color, width: '100px', height: '100px' }}
        ></div>
        <button type="button" onClick={() => changeColor('red')}>RED</button>
        <button type="button" onClick={() => changeColor('orange')}>ORANGE</button>
        <button type="button" onClick={() => changeColor('green')}>GREEN</button>
      </>
    );
  }
}

export default Color;