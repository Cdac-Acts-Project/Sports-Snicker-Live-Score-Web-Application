import { TypeAnimation } from 'react-type-animation';

const HomeTypeAnimation = () => {
  return (
    <TypeAnimation
      sequence={[
        // Same substring at the start will only be typed out once, initially
        'for',
        1000, // wait 1s before replacing "Mice" with "Hamsters"
        'for Cricket Lovers',
        1000,
        'for Football Lovers',
        1000,
        'for Hockey Lovers',
        1000
      ]}
      wrapper="span"
      speed={70}
      style={{ fontSize: '1em', display: 'inline-block' }}
      repeat={Infinity}
    />
  );
};

export default HomeTypeAnimation;