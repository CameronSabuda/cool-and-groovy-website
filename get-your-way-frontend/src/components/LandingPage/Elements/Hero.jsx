import React from 'react'
import { Container, Row, Col, Image } from 'react-bootstrap'
import HeroPic from '../Assets/hero.svg'
import { ReactComponent as ScrollIcon } from '../Assets/mouseScroll.svg'

import { scroller } from 'react-scroll'

const Centered = {
	position: 'relative',
	top: '25%',
	left: '25%',
	transform: 'translate(-25%, -25%)',
}

const Hero = () => {
	return (
		<div className='bg-light py-5 px-2'>
			<Container style={{ height: '80vh' }}>
				<Row className='justify-content-center py-4' style={Centered}>
					<Col sm={12} md={5} className='mx-2'>
						<Image src={HeroPic} rounded fluid />
					</Col>
					<Col sm={12} md={6} className='d-flex align-items-center px-5'>
						<h1 className='text-black'>Discover movie scenes around the world</h1>
					</Col>
				</Row>
			</Container>
					<div className="text-center">
						<ScrollIcon onSelect={() => scroller.scrollTo('') } />
					</div>
		</div>
	)
}

export default Hero
