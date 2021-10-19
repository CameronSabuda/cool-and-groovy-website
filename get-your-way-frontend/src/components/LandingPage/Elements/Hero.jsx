import React from 'react'
import { Container, Row, Col, Image } from 'react-bootstrap'
import HeroPic from '../Assets/hero.svg'

const Centered = {
	position: 'relative',
	top: '25%',
	left: '25%',
	transform: 'translate(-25%, -25%)',
}

const Hero = () => {
	return (
		<div className='bg-light py-5 px-2'>
			<Container style={{ height: '100vh' }}>
				<Row className='justify-content-center py-4' style={Centered}>
					<Col sm={12} md={5} className='mx-2'>
						<Image src={HeroPic} rounded fluid />
					</Col>
					<Col sm={12} md={6} className='d-flex align-items-center px-5'>
						<h1 className='text-black'>Discover movie scenes around the world</h1>
					</Col>
				</Row>
			</Container>
		</div>
	)
}

export default Hero
