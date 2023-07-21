const registrazione=document.querySelector('.registrazione');
const btnregistrazione=document.querySelector('.registrati');
const accesso=document.querySelector('.accesso');
const btnaccesso=document.querySelector('.accedi');

btnregistrazione.addEventListener('click',()=>{
	registrazione.classList.add('active-popup-registrazione');
	accesso.classList.remove('active-popup-accesso');
});

btnaccesso.addEventListener('click',()=>{
	accesso.classList.add('active-popup-accesso');
	registrazione.classList.remove('active-popup-registrazione');
});