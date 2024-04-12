import { useState } from 'react';

const Profile = () => {
  const [data, setData] = useState({
    name: '이이름',
    age: 40,
  });

  const changeProfile = () => {
    // data.name = '김이름';  // 주소값이 같으면 같은걸로 보기떄문에 렌더링 안됨
    //data.age = 30;
    //setData({ name: '김이름', age: 30 });
    setData({ ...data, name: '김이름' });  // 전개연산자사용, 바꾸고싶은것만 바꿈

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