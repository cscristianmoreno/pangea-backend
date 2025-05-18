DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA IF NOT EXISTS public;

-- DO $$
-- 	DECLARE
-- 		value RECORD;
-- 	BEGIN
-- 		SELECT typname FROM pg_type WHERE typname = 'roles_type' INTO value;
		
-- 		IF value IS NOT NULL THEN
-- 			RETURN;
-- 		END IF;
		
-- 		CREATE TYPE roles_type AS ENUM(
-- 			'ADMINISTRADOR',
-- 			'VENDEDOR',
-- 			'COMPRADOR'
-- 		);
-- 	END;
-- $$;