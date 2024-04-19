import { Component } from 'react';

class Color extends Component {
  state = { // 상태값
    color: 'blue',
    subColor: 'black',
  };

  render() {  // 컴포넌트의 필수

    // function changeColor(color) {
    //     console.log(this);
    // }
    
    // const changeColor = (color) => console.log(this);  // Color
    const changeColor = (color) => this.setState({ color }); // Color
    const changeSubColor = (color) => this.setState((prevState) => ({ ...prevState, subColor: color }));


    const { color, subColor } = this.state;
    return (
      <>
        <div
          style={{ background: color, width: '100px', height: '100px' }}></div>
        <button type="button" onClick={() => changeColor('red')} onContextMenu={() => changeSubColor('red')}>RED</button>
        <button type="button" onClick={() => changeColor('orange')} onContextMenu={() => changeSubColor('orange')}>ORANGE</button>
        <button type="button" onClick={() => changeColor('green')} onContextMenu={() => changeSubColor('green')}>GREEN</button>

        <div style={{ background: subColor, width: '50px', height: '50px' }}></div>
      </>
    );
  }
}

export default Color;