import axios, { AxiosResponse } from "axios";
import { despesasData } from "../Interface/despesasData";
import { useQuery } from "@tanstack/react-query";

const API_URL = 'http://localhost:8080';

// Função para buscar os dados da API
const fetchData = async (): Promise<despesasData[]> => {
    const response: AxiosResponse<despesasData[]> = await axios.get(API_URL + '/expense');
    return response.data;  // Retorna diretamente o array de despesas
}

export function useDespesaData() {
    // Tipando o retorno de useQuery com o tipo correto
    const query = useQuery<despesasData[]>({
        queryFn: fetchData,
        queryKey: ['expense-data'],
        retry: 2,
    });

    return query;
}
