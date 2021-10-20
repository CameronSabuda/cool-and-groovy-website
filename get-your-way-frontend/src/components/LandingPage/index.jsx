import React from "react";
import Hero from "./Elements/Hero.jsx";
import Example from "./Elements/Examples.jsx";
import TryItOut from "./Elements/TryItOut.jsx";
import './index.css'


const index = () => {
	return (
		<div>
			<Hero />
			<Example />
			<TryItOut />
		</div>
	);
};

export default index;
