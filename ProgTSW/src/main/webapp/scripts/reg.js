const registrazione=document.querySelector('.registrazione');
const btnregistrazione=document.querySelector('.registrati');
const accesso=document.querySelector('.accesso');
const btnaccesso=document.querySelector('.accedi');
const chiudi_accesso=document.querySelector('.X_accesso');
const chiudi_registrazione=document.querySelector('.X_registrazione');
const prodotti=document.querySelector('.prodotti');

btnregistrazione.addEventListener('click',()=>{
	registrazione.classList.add('active-popup-registrazione');
	accesso.classList.remove('active-popup-accesso');
	prodotti.classList.add('active-popup-prodotti');
});

btnaccesso.addEventListener('click',()=>{
	accesso.classList.add('active-popup-accesso');
	registrazione.classList.remove('active-popup-registrazione');
	prodotti.classList.add('active-popup-prodotti');
});

chiudi_accesso.addEventListener('click',()=>{
	accesso.classList.remove('active-popup-accesso');
	prodotti.classList.remove('active-popup-prodotti');
});

chiudi_registrazione.addEventListener('click',()=>{
	registrazione.classList.remove('active-popup-registrazione');
	prodotti.classList.remove('active-popup-prodotti');
});
