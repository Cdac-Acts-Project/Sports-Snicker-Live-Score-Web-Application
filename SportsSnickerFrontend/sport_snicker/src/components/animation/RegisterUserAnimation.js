import { TypeAnimation } from 'react-type-animation';

const RegisterUserAnimation = () => {
  return (
    <TypeAnimation
      sequence={[
        // Same substring at the start will only be typed out once, initially
        'Enter information to Register',
        1000, // wait 1s before replacing "Mice" with "Hamsters"
        'Enter information to Login',
        1000,
      ]}
      wrapper="span"
      speed={70}
      style={{ fontSize: '1em', display: 'inline-block' }}
      repeat={Infinity}
    />
  );
};

export default RegisterUserAnimation;