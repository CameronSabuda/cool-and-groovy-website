import React, { useEffect, useState } from 'react'
import EventsTile from './EventsTile/EventsTile'
import axios from 'axios'
import { Container, Row, CardGroup } from 'react-bootstrap'
import Loader from '../Loader/Loader'
import './EventsBar.css'

const client = axios.create({
	baseURL: 'http://99.81.186.138:9090/events?latitude=51.5074&longitude=-0.1278',
})

const EventsBar = () => {
	const [eventsData, setEventsData] = useState()
	const [isLoading, setLoading] = useState(true)

	useEffect(() => {
		const getEvents = async () => {
			let response = await client.get()
			let { events } = response.data

			setEventsData(events)
			setLoading(false)
		}
		getEvents()
	}, [])

	return (
		<div className='EventsBar bg-secondary vw-100 px-2 py-3'>
			<Container fluid>
				<CardGroup className='d-flex flex-row flex-nowrap scrolling'>
					{isLoading && <Loader />}
					{!isLoading &&
						eventsData.map((event, i) => {
							return <EventsTile data={event} key={i} />
						})}
				</CardGroup>
			</Container>
		</div>
	)
}

export default EventsBar
