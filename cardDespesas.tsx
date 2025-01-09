import "./cardDespesas.css";

interface CardProps{
    id:number, 
    nameExpense: string,
    valueExpense: number,
    valueMensalInstallment:number,
    dayPay: number,
    categoryExpense: string
}
export function CardDespesas({nameExpense, valueExpense, valueMensalInstallment, dayPay, categoryExpense} : CardProps){
    return <>
    <div className="card">
        <p className="name">{nameExpense}</p>
        <p className="valueExpense"><b>Valor: {valueExpense} </b></p>
        <p className="valueMensalInstallment"> Valor Mensal: {valueMensalInstallment} </p>
        <p className="dayPay">Dia pagamento: {dayPay} </p>
        <p className="categoryExpense">{categoryExpense}</p>
    </div>
    
    </>
}