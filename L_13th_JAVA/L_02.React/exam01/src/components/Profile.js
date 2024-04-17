import { useState } from 'react';

const Profile = () => {
  const [data, setData] = useState({
    name: '이이름',
    age: 40,
  });

  // const d1 = data;
  
  const changeProfile = () => {
    /*
    // data.name = '김이름';  // 주소값이 같으면 같은걸로 보기떄문에 렌더링 안됨
    //data.age = 30;
    //console.log(data);  // 값은 변경되었으나 렌더링이 안되었기떄문에 이전값이 출력
    //setData(data);
    //setData({ name: '김이름', age: 30 });
    //setData({ ...data, name: '김이름' });  // 전개연산자사용, 바꾸고싶은것만 바꿈
        setData((state) => {
        console.log('이전 상태값 : ', state);
  
        return { ...state, name: '김이름' };
      });
    */

    // data.name = '김이름';
    // data.age = 30;
    //const d2 = data;
    // const newData = { name: '김이름', age: 30 };
    // console.log(data === newData);
    //setData(newData);
    //setData({ ...data, name: '김이름' });
    setData((prevState) => {
      console.log('변경전 상태값 : ', prevState);
      return { ...prevState, name: '김이름' };
    });


  };

  const { name, age } = data;
  return (
    <>
      <h1>{name}</h1>
      <h2>{age}</h2>
      <button type="button" onClick={changeProfile}>
        변경
      </button>
    </>
  );
};

export default Profile;