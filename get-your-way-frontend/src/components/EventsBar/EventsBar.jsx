import React, { useEffect, useState } from "react";
import EventsTile from './EventsTile/EventsTile';
import axios from 'axios';
import { CardGroup } from "react-bootstrap";


const client = axios.create({
    baseURL: "http://localhost:4000/events"
})

const EventsBar = () => {
    const [events, setEvents] = useState(null)

    useEffect(() => {
        const getEvents =  async () => {
            let response = await client.get()
            setEvents(response.data)
        }
        getEvents()
    }, [])


    return (
        <div className= 'EventsBar bg-secondary'>
            <CardGroup className='d-flex flex-row'>
                {events && events.map((event, i) => {
                    return <EventsTile data={event} key={i}/>
                })}
            </CardGroup>
        </div>
    )
}

export default EventsBar;
