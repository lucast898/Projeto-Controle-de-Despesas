import './App.css'
import { CardDespesas } from './Components/card/cardDespesas';
import { useDespesaData } from './Hooks/useDespesaData';
import { despesasData } from './Interface/despesasData';

function App() {
  const { data } = useDespesaData();
  
  return (
    <>
    
      <div className= "container">
        <h1>Despesas</h1>
        <div className="card-despesas">
        {data?.map(despesasData => 
          <CardDespesas
            id={despesasData.id} 
            nameExpense = {despesasData.nameExpense} 
            valueExpense = {despesasData.valueExpense}
            valueMensalInstallment = {despesasData.valueMensalInstallment}
            dayPay = {despesasData.dayPay}
            categoryExpense ={despesasData.categoryExpense}
          />
        )}

        </div>
      </div>
    </>
  )
}

export default App