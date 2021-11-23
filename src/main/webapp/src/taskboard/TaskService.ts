import axios from 'axios';
import {TaskboardItem, TaskboardItemStatus} from './TaskboardTypes';

const production  = 'https://tasket-demo.herokuapp.com';
const development = 'http://localhost:8080/';
const BASE_URL = (process.env.NODE_ENV ? production : development);

export const createTask = (task: { description: string; position: number; id: string; title: string; status: TaskboardItemStatus }) => axios.post<TaskboardItem>(`${BASE_URL}/tasks`, task);

export const getAllTasks = () => axios.get<TaskboardItem[]>(`${BASE_URL}/tasks`);

export const changeTaskPosition = (task: TaskboardItem) => axios.post(`${BASE_URL}/tasks/position`, task);

export const deleteTask = (id: number) => axios.delete(`${BASE_URL}/tasks/${id}`);

export const updateTask = (task: TaskboardItem) => axios.put<TaskboardItem>(`${BASE_URL}/tasks/${task.id}`, task);
