import { render, screen } from '@testing-library/react';
import App from './StudentManager';

test('renders Student Manager', () => {
  render(<App />);
  const heading = screen.getByText('Student Manager');
  expect(heading).toBeInTheDocument();
});

test('renders initial students', () => {
  render(<App />);
  expect(screen.getByText('John Doe')).toBeInTheDocument();
  expect(screen.getAllByRole('row')).toHaveLength(6); // 1 header + 5 students
});

