import { TypeAnimation } from 'react-type-animation';

const SportSnickerAnimation = () => {
  return (
    <TypeAnimation
      sequence={[
        // Same substring at the start will only be typed out once, initially
        'Live Score - ',
        500, // wait 1s before replacing "Mice" with "Hamsters"
        'Live Score - Cricket',
        1000,
        'Live Score - Football',
        1000,
        'Live Score - Hockey',
        1000,
      ]}
      wrapper="span"
      speed={50}
      style={{ fontSize: '2em', display: 'inline-block' }}
      repeat={Infinity}
    />
  );
};

export default SportSnickerAnimation;