import React from "react";
import { Container, Row, Col, Image } from "react-bootstrap";

const Hero = () => {
	return (
		<div className="bg-light py-5">
			<Container style={ {height: '100vh'} }>
				<Row className='d-flex justify-content-center py-4 px-4'>
					{/* hero image */}
					<Col md={6} className="mx-2 ">
						<Image src='https://picsum.photos/1200/720' rounded fluid/>
					</Col>
					{/* Tagline */}
					<Col className='d-flex align-items-center px-5'>
						<h1>Discover movie scenes around the world</h1>
					</Col>
				</Row>
			</Container>
		</div>
	);
};

export default Hero;
