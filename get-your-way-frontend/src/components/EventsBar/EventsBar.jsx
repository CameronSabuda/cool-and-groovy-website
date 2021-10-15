import React, { useEffect, useState } from "react";
import EventsTile from './EventsTile/EventsTile';
import axios from 'axios';


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
        <div className= 'EventsBar d-flex bg-secondary'>
            {events && events.map((event, i) => {
                return <EventsTile data={event} key={i}/>
            })}
        </div>
    )
}

export default EventsBar;
